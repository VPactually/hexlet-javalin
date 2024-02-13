package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.EditCoursePage;
import org.example.hexlet.NamedRoutes;
public final class JteeditGenerated {
	public static final String JTE_NAME = "courses/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,5,5,7,7,9,9,10,10,11,11,11,12,12,13,13,15,15,20,20,20,20,20,20,20,20,20,22,22,22,31,31,31,46,46,46,47,47,47,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditCoursePage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div align=\"left\">\n        ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n            <ul>\n                ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                    ");
						for (var error : validator) {
							jteOutput.writeContent("\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                    ");
						}
						jteOutput.writeContent("\n                ");
					}
					jteOutput.writeContent("\n            </ul>\n        ");
				}
				jteOutput.writeContent("\n    </div>\n\n\n    <div align=\"left\">\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.coursePath(page.getCourse().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n            <div>\n                <p>Текущий заголовок - ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("</p>\n                <p>\n                    Заголовок\n                    <label>\n                        <input type=\"text\" name=\"name\"/>\n                    </label>\n                </p>\n            </div>\n            <div>\n                <p>Текущее описание - ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getDescription());
				jteOutput.writeContent("</p>\n                <label>\n                    <p>\n                        Описание\n                        <input type=\"text\" name=\"description\"/>\n                    </p>\n\n                </label>\n            </div>\n            <br>\n            <input type=\"submit\" value=\"Обновить\"/>\n        </form>\n    </div>\n\n\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditCoursePage page = (EditCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
