package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addComment(@RequestParam(name="comment") String comment, @PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, HttpSession session) {

        User user = (User) session.getAttribute("loggeduser");
        Comment commentObj = new Comment();
        commentObj.setText(comment);
        commentObj.setUser(user);
        commentObj.setCreatedDate(LocalDate.now());
        commentService.createComment(commentObj);
        return "redirect:/images/" + imageId + "/" + imageTitle;
    }
}
