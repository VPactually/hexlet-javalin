@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes
@param UserPage page


@template.layout.page(content = @`
    <div class="snippet-container" align="right"><a href="${NamedRoutes.editUserPath(page.getUser().getId())}">Edit</a></div>
    <div class="description-from-type-label">
        <h2>${page.getUser().getId()}</h2>
        <p>${page.getUser().getName()}</p>
        <p>${page.getUser().getEmail()}</p>
    </div>
`,
    page = page
)

