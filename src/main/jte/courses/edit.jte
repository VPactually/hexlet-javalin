@import org.example.hexlet.dto.courses.EditCoursePage
@import org.example.hexlet.NamedRoutes
@param EditCoursePage page


@template.layout.page(page = page, content = @`
    <div align="left">
        @if (page.getErrors() != null)
            <ul>
                @for (var validator : page.getErrors().values())
                    @for (var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
    </div>


    <div align="left">
        <form action="${NamedRoutes.coursePath(page.getCourse().getId())}" method="post">
            <div>
                <p>Текущий заголовок - ${page.getCourse().getName()}</p>
                <p>
                    Заголовок
                    <label>
                        <input type="text" name="name"/>
                    </label>
                </p>
            </div>
            <div>
                <p>Текущее описание - ${page.getCourse().getBody()}</p>
                <label>
                    <p>
                        Описание
                        <input type="text" name="description"/>
                    </p>

                </label>
            </div>
            <br>
            <input type="submit" value="Обновить"/>
        </form>
    </div>


`)
