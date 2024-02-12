@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
page = page,
content = @`
    <div class="container" align="right">
        <a href="/courses/build">Create course</a>
    </div>

    <div class="container">
        @if(page.getCourses().isEmpty())
            <p>Not found any courses</p>
            <a href="/courses">Back</a>
        @else
            <h2>Courses list</h2>
            <form class="nav active" action="/courses" method="get">
                <label>
                    <input type="search" required name="term">
                </label>
                <input class="nav-link" type="submit" value="Искать">
            </form>
            <div align="right">
                <form action="/courses" method="get">
                    <input type="hidden" name="page" value="1">
                    <label>
                        <select name="per">
                            <option value="10" selected>10</option>
                            <option value="20">20</option>
                            <option value="50">50</option>
                        </select>
                    </label>
                    <input class="btn btn-primary btn-sm" type="submit" value="Show">
                </form>
            </div>

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
            </table>
        @endif
    </div>
`
)