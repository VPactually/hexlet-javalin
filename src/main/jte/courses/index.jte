@import org.example.hexlet.dto.courses.CoursesPage

@param CoursesPage page

<!doctype html>
<html>
<head>
    Hexlet
</head>
<body>
<h1>
    ${page.getHeader()}
    @if(page.getCourses().isEmpty())
        <p>Still not added new courses</p>
    @else
        @for(var course : page.getCourses())
            <div>
                <h2>
                    <a href="/courses/${course.getId()}">${course.getName()}</a>
                </h2>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
</h1>
</body>
</html>
