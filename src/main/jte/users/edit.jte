@import org.example.hexlet.dto.users.EditUserPage
@import org.example.hexlet.NamedRoutes
@param EditUserPage page


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
    <form action="${NamedRoutes.userPath(page.getUser().getId())}" method="post">
        <div>
            <p>Текущее имя - ${page.getUser().getName()}</p>
            <p>
                Имя
                <label>
                    <input type="text" name="name"/>
                </label>
            </p>
        </div>
        <div>
            <p>Текущий email - ${page.getUser().getEmail()}</p>
            <label>
                <p>
                    Email
                    <input type="email" name="email"/>
                </p>

            </label>
        </div>
        <br>
        <div>
            <label>
                Пароль
                <input type="password" required name="password"/>
            </label>
        </div>
        <br>
        <div>
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation"/>
            </label>
        </div>
        <br>
        <input type="submit" value="Зарегистрировать"/>
    </form>
</div>


`)
