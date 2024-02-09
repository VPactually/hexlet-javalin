@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <div class="description-from-type-label">
        <h2>${page.getUser().getId()}</h2>
        <p>${page.getUser().getFirstName()}</p>
        <p>${page.getUser().getEmail()}</p>
    </div>
`,
    page = page
)

