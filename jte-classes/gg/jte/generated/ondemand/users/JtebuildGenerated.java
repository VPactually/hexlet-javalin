package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,4,4,35,35,35,35,35,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\" align=\"left\">\n        <form action=\"/users\" method=\"post\">\n            <div>\n                <label>\n                    Имя\n                    <input type=\"text\" name=\"name\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Email\n                    <input type=\"email\" required name=\"email\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Пароль\n                    <input type=\"password\" required name=\"password\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Подтверждение пароля\n                    <input type=\"password\" required name=\"passwordConfirmation\" />\n                </label>\n            </div>\n            <input type=\"submit\" value=\"Зарегистрировать\" />\n        </form>\n    </div>\n\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
