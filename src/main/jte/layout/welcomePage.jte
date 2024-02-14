@import org.example.hexlet.model.pages.WelcomePage
@param WelcomePage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        <h2>Welcome, ${page.getName()}!!!</h2>
    @else
        <h2>Welcome !!!</h2>
    @endif
    @if(!page.isVisited())
        <h3>You see it only once</h3>
    @endif
`,
page = page
)