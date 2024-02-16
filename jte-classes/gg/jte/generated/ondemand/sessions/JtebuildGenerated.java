package gg.jte.generated.ondemand.sessions;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.sessions.BuildSessionPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "sessions/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,4,4,6,6,8,8,9,9,10,10,10,11,11,12,12,14,14,15,15,15,16,16,18,18,18,18,18,18,18,18,18,30,30,30,31,31,31,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildSessionPage page) {
		jteOutput.writeContent("\n");
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
				} else if (page.getError() != null) {
					jteOutput.writeContent("\n            <ul><li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(page.getError());
					jteOutput.writeContent("</li></ul>\n        ");
				}
				jteOutput.writeContent("\n\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n            <label>\n                <input type=\"email\" placeholder=\"email\" name=\"email\" />\n            </label>\n            <label>\n                <input type=\"password\" placeholder=\"password\" name=\"password\" />\n            </label>\n            <input type=\"submit\" />\n        </form>\n    </div>\n    \n\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildSessionPage page = (BuildSessionPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
