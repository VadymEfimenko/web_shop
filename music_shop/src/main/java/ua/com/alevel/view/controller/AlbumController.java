package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.AlbumFacade;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.view.dto.request.AlbumRequestDto;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumFacade albumFacade;
    private final UserFacade userFacade;

    public AlbumController(AlbumFacade albumFacade, UserFacade userFacade) {
        this.albumFacade = albumFacade;
        this.userFacade = userFacade;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("albums", albumFacade.findAll());
        return "/pages/albums/albums_all";
    }

    @GetMapping("/new")
    public String redirectToNewAlbumPage(Model model){
        model.addAttribute("album", new AlbumRequestDto());
        return "pages/albums/album_new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("product") AlbumRequestDto dto) {
        albumFacade.create(dto);
        return "redirect:/albums";
    }
}
