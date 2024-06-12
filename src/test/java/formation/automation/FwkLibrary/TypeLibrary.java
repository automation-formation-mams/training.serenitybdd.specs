package formation.automation.FwkLibrary;

import net.serenitybdd.core.pages.WebElementFacade;

public class TypeLibrary {
    public static final String EMPTY = "_EMPTY_";
    public static final String ENTER = "{Return}";
    public static final String TAB = "{Tab}";

    public static void type(WebElementFacade element, String s, Boolean clearBeforeTyping, String typeAfter) {
        String txt = s;
        if (s.equalsIgnoreCase(TypeLibrary.EMPTY)) {
            txt = "";
        }
        if (clearBeforeTyping)
            element.clear();
        if (typeAfter.equals(TypeLibrary.TAB))
            element.typeAndTab(s);
        else if (typeAfter.equals(TypeLibrary.ENTER))
            element.typeAndEnter(s);
        else
            element.type(s);
    }

    public static void type(WebElementFacade element, String s) {
        type(element, s, true, "");
    }

    public static void typeAndTab(WebElementFacade element, String s) {
        type(element, s, true, TypeLibrary.TAB);
    }

    public static void typeAndEnter(WebElementFacade element, String s) {
        type(element, s, true, TypeLibrary.ENTER);
    }

}
