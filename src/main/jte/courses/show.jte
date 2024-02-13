@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes
@param CoursePage page

@template.layout.page(page = page, content =@`
    <div class="snippet-container" align="right"><a href="${NamedRoutes.editCoursePath(page.getCourse().getId())}">Edit</a></div>
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getDescription()}</p>` )

