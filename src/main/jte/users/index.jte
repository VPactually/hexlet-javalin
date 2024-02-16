@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.repository.repositories.UserRepository
@param UsersPage page

@template.layout.page(
page = page,
content = @`
    <div class="container" align="right">
        <a href="${NamedRoutes.buildUserPath()}">Create user</a>

    </div>
    <div class="container">
        @if(page.getUsers().isEmpty())
            <p>Not found any users</p>
            <a href="${NamedRoutes.usersPath()}">Back</a>
        @else
            @if(page.getFlash() != null)
                <p class="alert alert-success" role="alert">${page.getFlash().toString()}</p>
            @endif
            <h2>Users list</h2>
            <form class="nav active" action="${NamedRoutes.usersPath()}" method="get">
                <label>
                    <input type="search" required name="term">
                </label>
                <input class="nav-link" type="submit" value="Search">
            </form>
            <div align="right">
                <form action="${NamedRoutes.usersPath()}" method="get">
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
                    <th>Email</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                @for(var user : page.getUsers())
                    <tr>
                        <td><a href="${NamedRoutes.userPath(user.getId())}">${user.getId()}</a></td>
                        <td>${user.getEmail()}</td>
                        <td>${user.getName()}</td>
                    </tr>
                @endfor
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-end">
                    <li class="page-item ${page.getPageNumber() > 1 ? "" : "disabled"}">
                        <a class="page-link"
                           href="${NamedRoutes.usersPath()}?page=${page.getPageNumber() - 1}&per=${page.getPerPage()}">Previous</a>
                    </li>
                    <li class="page-item ${page.getPageNumber()*page.getPerPage() < UserRepository.size() ? "" : "disabled"}">
                        <a class="page-link"
                           href="${NamedRoutes.usersPath()}?page=${page.getPageNumber() + 1}&per=${page.getPerPage()}">Next</a>
                    </li>
                </ul>
            </nav>
        @endif
    </div>
`
)
