import androidx.compose.runtime.Composable
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposableInBody
import org.w3c.dom.events.Event

fun main() {
    renderComposableInBody { Website() }
    window.onload = ::onLoad
}

@Suppress("UNUSED_PARAMETER")
private fun onLoad(event: Event) {
    document.body?.className = document.body?.className?.replace("is-preload", "").orEmpty()
    document.body?.className += if (window.navigator.userAgent.matches("(MSIE|rv:11\\.0)".toRegex())) " is-ie" else ""
}

@Composable
private fun Website() {
    Div(attrs = { id("wrapper") }) {
        AboutMeSection()
        WebsiteFooter()
    }
}

@Composable
private fun AboutMeSection() {
    Section(attrs = { id("main") }) {
        CardHeader()
        CardFooter()
        ProjectsSection()
    }
}

@Composable
private fun CardHeader() {
    Header {
        Span(attrs = { classes("avatar") }) {
            Img(src = "images/magnum.jpg", alt = "")
        }
        H1 { Text("Magnum Rocha") }
        P { Text("Mobile Developer") }
    }
}

@Composable
private fun CardFooter() {
    Footer {
        Ul(attrs = { classes("icons") }) {
            mapOf(
                "github" to "https://github.com/magnumrocha",
                "medium" to "https://medium.com/@magnumrocha",
                "linkedin" to "https://www.linkedin.com/in/magnumrocha"
            ).forEach { (media, link) ->
                Li {
                    A(href = link, attrs = { classes("icon", "brands", "fa-$media"); target(ATarget.Blank) }) {
                        Text(media)
                    }
                }
                Text(" ")
            }
        }
    }
}

@Composable
private fun ProjectsSection() {
    Section(attrs = { id("projects") }) {
        Hr()
        H2 { Text("Check out my Work") }
        Ul(attrs = { style { property("list-style-type", "none") } }) {
            Li {
                A(href = "https://github.com/TM-Apps/konnection", attrs = { target(ATarget.Blank) }) {
                    U { Text("Konnection") }
                }
            }
        }
        Hr()
    }
}

@Composable
private fun ExtraContent() {
    Hr()
    H2 { Text("Extra Stuff!") }
    Form(action = "#", attrs = { method(FormMethod.Post) }) {
        Div(attrs = { id("fields") }) {
            Div(attrs = { id("field") }) {
                Input(type = InputType.Text) {
                    id("name")
                    name("name")
                    placeholder("Name")
                }
            }
            Div(attrs = { id("field") }) {
                Input(type = InputType.Email) {
                    id("email")
                    name("email")
                    placeholder("Email")
                }
            }
            Div(attrs = { id("field") }) {
                Select(attrs = { id("department"); name("department") }) {
                    Option(value = "") { Text("Department") }
                    Option(value = "sales") { Text("Sales") }
                    Option(value = "tech") { Text("Tech Support") }
                    Option(value = "null") { Text("/dev/null") }
                }
            }
            Div(attrs = { id("field") }) {
                TextArea {
                    rows(4)
                    name("message")
                    id("message")
                }
            }
            Div(attrs = { id("field") }) {
                Input(type = InputType.Checkbox) {
                    name("human")
                    id("human")
                }
                Label(forId = "human") { Text("I'm a human") }
            }
            Div(attrs = { id("field") }) {
                Label { Text("But are you a robot?") }
                Input(type = InputType.Radio) {
                    name("robot")
                    id("robot_yes")
                }
                Label(forId = "robot_yes") { Text("Yes") }
                Input(type = InputType.Radio) {
                    name("robot")
                    id("robot_no")
                }
                Label(forId = "robot_no") { Text("No") }
            }
        }
        Ul(attrs = { classes("actions", "special") }) {
            Li {
                A(href = "#", attrs = { classes("button") }) {
                    Text("Get Started")
                }
            }
        }
    }
    Hr()
}

@Composable
private fun WebsiteFooter() {
    Footer(attrs = { id("footer") }) {
        Ul(attrs = { classes("copyright") }) {
            Li { Text("© Magnum Rocha") }
            Li {
                Text("Design:")
                A(href = "http://html5up.net", attrs = { target(ATarget.Blank) }) {
                    Text(" HTML5 UP")
                }
            }
        }
    }
}
