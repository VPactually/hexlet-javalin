@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(page = page,
content = @`
    <div class="container" align="left" >
    @if (page.getErrors() != null)
        <ul >
            @for (var validator : page.getErrors().values())
                @for (var error : validator)
                    <li class="alert alert-danger">${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

        <form action="/courses" method="post">
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