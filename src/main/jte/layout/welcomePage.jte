@import org.example.hexlet.model.WelcomePage
@param WelcomePage page

@template.layout.page(
content = @`
    <h2>Welcome !!!</h2>
    <p>This site created by ${page.getName()}</p>

`,
footer = @`
    <p><a href="https://github.com/VPactually">Created by VP</a></p>
`
)