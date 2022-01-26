package ru.itmo.wp.lesson8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.lesson8.domain.Notice;
import ru.itmo.wp.lesson8.form.NoticeForm;
import ru.itmo.wp.lesson8.form.validator.NoticeCredentialsSaveValidator;
import ru.itmo.wp.lesson8.service.NoticeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class NewNoticePage extends Page{
    private final NoticeService noticeService;
    private final NoticeCredentialsSaveValidator noticeCredentialsSaveValidator;

    public NewNoticePage(NoticeService noticeService, NoticeCredentialsSaveValidator noticeCredentialsSaveValidator) {
        this.noticeService = noticeService;
        this.noticeCredentialsSaveValidator = noticeCredentialsSaveValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (binder.getTarget() == null) return;
        if (noticeCredentialsSaveValidator.supports(binder.getTarget().getClass())) {
            binder.addValidators(noticeCredentialsSaveValidator);
        }
    }

    @GetMapping("/notices/new")
    public String save(Model model) {
        model.addAttribute("noticeForm", new NoticeForm());
        return "NewNoticePage";
    }

    @PostMapping("/notices/new")
    public String save(@Valid @ModelAttribute("noticeForm") NoticeForm noticeForm,
                       BindingResult bindingResult,
                       HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "NewNoticePage";
        }
        Notice notice = new Notice();
        notice.setContent(noticeForm.getContent());
        noticeService.save(notice);
        return "redirect:/";
    }
}
