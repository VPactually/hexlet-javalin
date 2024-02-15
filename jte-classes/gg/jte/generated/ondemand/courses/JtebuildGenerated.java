package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,4,4,6,6,8,8,9,9,10,10,10,11,11,12,12,14,14,32,32,32,32,32,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\" align=\"left\" >\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n        <ul >\n            ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                ");
						for (var error : validator) {
							jteOutput.writeContent("\n                    <li class=\"alert alert-danger\">");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                ");
						}
						jteOutput.writeContent("\n            ");
					}
					jteOutput.writeContent("\n        </ul>\n    ");
				}
				jteOutput.writeContent("\n\n        <form action=\"/courses\" method=\"post\">\n            <div>\n                <label>\n                    Название\n                    <input type=\"text\" name=\"name\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Описание\n                    <input type=\"text\" required name=\"description\" />\n                </label>\n            </div>\n            <input type=\"submit\" value=\"Создать курс\" />\n        </form>\n    </div>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
