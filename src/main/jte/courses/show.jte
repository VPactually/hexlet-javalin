@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes
@param CoursePage page

@template.layout.page(page = page, content =@`
    <div class="offset-md-11" >
        <form><a href="${NamedRoutes.editCoursePath(page.getCourse().getId())}">Edit</a></form>
        <form action="${NamedRoutes.deleteCoursePath(page.getCourse().getId())}" method="post">
            <button type="submit" class="btn btn-link">Delete</button>
        </form>
    </div>
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getBody()}</p>
` )

