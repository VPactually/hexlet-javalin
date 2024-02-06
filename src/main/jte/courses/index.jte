@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <div class="container">
        @if(page.getCourses().isEmpty())
            <p>Still not added new courses</p>
        @else
            <h2>Courses list</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Full name of the course</th>
                </tr>
                </thead>
                <tbody>
                @for(var course : page.getCourses())
                    <tr>
                        <td><a href="/courses/${course.getId()}">${course.getId()}</a></td>
                        <td>${course.getName()}</td>
                        <td>${course.getDescription()}</td>
                        <td>${course.toString()}</td>
                    </tr>

                @endfor
                </tbody>
                <tr>
                    <td colspan="4">
                        @if (page.getCurrentPage() < page.getTotalPages())
                        @if (page.getCurrentPage() > 1)
                            <a href="/courses?page=${page.getCurrentPage()-1}&per=${page.getPerParam()}">Previous</a>
                        @endif
                        <a href="/courses?page=${page.getCurrentPage()+1}&per=${page.getPerParam()}">Next</a>
                    </td>
                    @else
                        <a href="/courses?page=${page.getCurrentPage()-1}&per=${page.getPerParam()}">Previous</a>
                    @endif
                </tr>
            </table>
        @endif
    </div>
`
)