package gg.jte.generated.ondemand.layout;
import org.example.hexlet.model.WelcomePage;
public final class JtewelcomePageGenerated {
	public static final String JTE_NAME = "layout/welcomePage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,8,8,8,10,10,10,10,12,12,12,12,12,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, WelcomePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h2>Welcome!!!</h2>\n    <p>This site created by ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</p>\n\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <p><a href=\"https://github.com/VPactually\">Created by VP</a></p>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		WelcomePage page = (WelcomePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
