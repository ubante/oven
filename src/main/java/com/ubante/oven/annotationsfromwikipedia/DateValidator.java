//package com.ubante.oven.annotationsfromwikipedia;
//
///**
// * Created by ubante on 5/22/14.
// */
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.validator.Validator;
//import javax.faces.validator.ValidatorException;
////
////import com.annotation.UnderConstruction;
////import com.annotation.Unfinished;
////import com.annotation.Unfinished.Priority;
//
//@UnderConstruction(owner="Navin Gujarish")
//public class DateValidator implements Validator {
//
//    public void validate(FacesContext context, UIComponent component, Object value)
//            throws ValidatorException
//    {
//        String date = (String) value;
//        String errorLabel = "Please enter a valid date.";
//        if (!component.getAttributes().isEmpty())
//        {
//            errorLabel = (String) component.getAttributes().get("errordisplayval");
//        }
//
//        if (!Util.validateAGivenDate(date))
//        {
//            @Unfinished(changedBy = "Steve",
//                    value = "whether to add message to context or not, confirm",
//                    priority = Priority.HIGH
//            )
//            FacesMessage message = new FacesMessage();
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            message.setSummary(errorLabel);
//            message.setDetail(errorLabel);
//            throw new ValidatorException(message);
//        }
//    }
//}
