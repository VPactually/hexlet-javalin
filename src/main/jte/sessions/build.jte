@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.sessions.BuildSessionPage
@param BuildSessionPage page

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
        @elseif(page.getError() != null)
            <ul><li>${page.getError()}</li></ul>
        @endif

        <form action="${NamedRoutes.sessionsPath()}" method="post">
            <label>
                <input type="email" placeholder="email" name="email" />
            </label>
            <label>
                <input type="password" placeholder="password" name="password" />
            </label>
            <input type="submit" />
        </form>
    </div>
    

`)
