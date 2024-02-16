package gg.jte.generated.ondemand.layout;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.model.pages.WelcomePage;
public final class JtewelcomePageGenerated {
	public static final String JTE_NAME = "layout/welcomePage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,8,8,9,9,9,11,11,11,11,11,11,11,11,11,14,14,16,16,17,17,19,19,20,20,20,20,20,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, WelcomePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getName() != null) {
					jteOutput.writeContent("\n        <h2>Welcome, ");
					jteOutput.setContext("h2", null);
					jteOutput.writeUserContent(page.getName());
					jteOutput.writeContent("!!!</h2>\n\n        <form");
					var __jte_html_attribute_0 = NamedRoutes.deleteSessionPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"post\">\n            <input class=\"btn btn-link\" type=\"submit\" value=\"Exit\">\n        </form>\n    ");
				} else {
					jteOutput.writeContent("\n        <h2>Welcome !!!</h2>\n    ");
				}
				jteOutput.writeContent("\n    ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n        <h3>You see it only once</h3>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		WelcomePage page = (WelcomePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
