@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.repository.CourseRepository
@param CoursesPage page

@template.layout.page(
page = page,
content = @`
    <div class="container" align="right">
        <a href="${NamedRoutes.buildCoursePath()}">Create course</a>
    </div>

    <div class="container">
        @if(page.getCourses().isEmpty())
            <p>Not found any courses</p>
            <a href="${NamedRoutes.coursesPath()}">Back</a>
        @else
            <h2>Courses list</h2>
            <form class="nav active" action="${NamedRoutes.coursesPath()}" method="get">
                <label>
                    <input type="search" required name="term">
                </label>
                <input class="nav-link" type="submit" value="Искать">
            </form>
            <div align="right">
                <form action="${NamedRoutes.coursesPath()}" method="get">
                    <input type="hidden" name="page" value="1">
                    <label>
                        <select name="per" onchange="this.form.submit()">
                            <option value="10">10</option>
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
                        <td><a href="${NamedRoutes.coursePath(course.getId())}">${course.getId()}</a></td>
                        <td>${course.getName()}</td>
                        <td>${course.getDescription()}</td>
                        <td>${course.toString()}</td>
                    </tr>
                @endfor
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-end">
                    <li class="page-item ${page.getPageNumber() > 1 ? "" : "disabled"}">
                        <a class="page-link" href="${NamedRoutes.coursesPath()}?page=${page.getPageNumber() - 1}&per=${page.getPerPage()}">Previous</a>
                    </li>
                    <li class="page-item ${page.getPageNumber()*page.getPerPage() < CourseRepository.size() ? "" : "disabled"}">
                        <a class="page-link" href="${NamedRoutes.coursesPath()}?page=${page.getPageNumber() + 1}&per=${page.getPerPage()}">Next</a>
                    </li>
                </ul>
            </nav>
        @endif
    </div>
`
)