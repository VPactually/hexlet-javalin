package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,5,5,7,7,9,9,10,10,11,11,11,12,12,13,13,15,15,17,17,17,17,17,17,17,17,17,21,21,21,21,21,21,21,21,21,27,27,27,27,27,27,27,27,27,45,45,45,46,46,46,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div align=\"left\">\n                ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n                    <ul>\n                        ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                            ");
						for (var error : validator) {
							jteOutput.writeContent("\n                                <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                            ");
						}
						jteOutput.writeContent("\n                        ");
					}
					jteOutput.writeContent("\n                    </ul>\n                ");
				}
				jteOutput.writeContent("\n\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n            <div>\n                <label>\n                    Имя\n                    <input type=\"text\" name=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\n                </label>\n            </div>\n            <div>\n                <label>\n                    Email\n                    <input type=\"email\" required name=\"email\"");
				var __jte_html_attribute_2 = page.getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\n                </label>\n            </div>\n            <div>\n                <label>\n                    Пароль\n                    <input type=\"password\" required name=\"password\"/>\n                </label>\n            </div>\n            <div>\n                <label>\n                    Подтверждение пароля\n                    <input type=\"password\" required name=\"passwordConfirmation\"/>\n                </label>\n            </div>\n            <input type=\"submit\" value=\"Зарегистрировать\"/>\n        </form>\n    </div>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}