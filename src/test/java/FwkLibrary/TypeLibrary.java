package FwkLibrary;

import net.serenitybdd.core.pages.WebElementFacade;

public class TypeLibrary {
    public static final String EMPTY = "_EMPTY_";
    public static final String ENTER = "{Return}";
    public static final String TAB = "{Tab}";

    public static void type(WebElementFacade element, String TexteToType, Boolean clearBeforeTyping, String typeAfter) {
        String txt = TexteToType;
        if (TexteToType.equalsIgnoreCase(TypeLibrary.EMPTY)) {
            txt = "";
        }
        if (clearBeforeTyping)
            element.clear();
        if (typeAfter.equals(TypeLibrary.TAB))
            element.typeAndTab(TexteToType);
        else if (typeAfter.equals(TypeLibrary.ENTER))
            element.typeAndEnter(TexteToType);
        else
            element.type(TexteToType);
    }

    public static void type(WebElementFacade element, String ValueToType) {
        type(element, ValueToType, true, "");
    }

    public static void typeAndTab(WebElementFacade element, String ValueToType) {
        type(element, ValueToType, true, TypeLibrary.TAB);
    }

    public static void typeAndEnter(WebElementFacade element, String ValueToType) {
        type(element, ValueToType, true, TypeLibrary.ENTER);
    }


}
