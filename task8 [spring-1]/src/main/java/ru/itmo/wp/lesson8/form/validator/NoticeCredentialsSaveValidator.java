package ru.itmo.wp.lesson8.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.lesson8.form.NoticeForm;
import ru.itmo.wp.lesson8.service.NoticeService;

@Component
public class NoticeCredentialsSaveValidator implements Validator {
    public final NoticeService noticeService;

    public NoticeCredentialsSaveValidator(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NoticeForm.class.equals((clazz));
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            NoticeForm noticeForm = (NoticeForm) target;
            if (noticeForm.getContent().length() > 20) {
                errors.rejectValue("content", "content.too-long-content", "notice more than 20");
            }
            if (noticeForm.getContent().length() < 1) {
                errors.rejectValue("content", "content.too-short-content", "notice must have at least one character");
            }
        }
    }
}
