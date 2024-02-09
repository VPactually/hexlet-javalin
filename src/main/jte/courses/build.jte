@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(page = page,
content = @`
    <div class="container" align="left">
        <form action="/users" method="post">
            <div>
                <label>
                    Название
                    <input type="text" name="name" />
                </label>
            </div>
            <div>
                <label>
                    Описание
                    <input type="text" required name="description" />
                </label>
            </div>
            <input type="submit" value="Создать курс" />
        </form>
    </div>
`)