package gg.jte.generated.ondemand.layout;
import org.example.hexlet.model.pages.WelcomePage;
public final class JtewelcomePageGenerated {
	public static final String JTE_NAME = "layout/welcomePage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,7,7,8,8,8,9,9,11,11,12,12,14,14,15,15,15,15,15,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, WelcomePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getName() != null) {
					jteOutput.writeContent("\n        <h2>Welcome, ");
					jteOutput.setContext("h2", null);
					jteOutput.writeUserContent(page.getName());
					jteOutput.writeContent("!!!</h2>\n    ");
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
