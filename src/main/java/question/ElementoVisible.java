package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoVisible {
    public static Question<Boolean> en(Target elemento) {
        return actor -> WebElementQuestion.the(elemento).answeredBy(actor).isCurrentlyVisible();
    }
}