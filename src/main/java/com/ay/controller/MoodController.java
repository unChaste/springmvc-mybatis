package com.ay.controller;

import com.ay.model.User;
import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import com.ay.response.MoodListResponse;
import com.ay.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping("/listMood")
    public String listMood(MoodListRequest request, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        request.setUserId(user.getId());
        List<MoodListResponse> moodList = moodService.listMood(request);
        model.addAttribute("moodList", moodList);
        model.addAttribute("user", user);
        return "moodList";
    }

    @GetMapping("/praise")
    public String praise(MoodPraiseRequest request) {
        moodService.praise(request);
        return "redirect:/mood/listMood";
    }

    @GetMapping("unpraise")
    public String unpraise(MoodUnpraiseRequest request) {
        moodService.unpraise(request);
        return "redirect:/mood/listMood";
    }
}
