package com.ats.prompt_service.controller;

import com.ats.prompt_service.entity.Prompt;
import com.ats.prompt_service.service.PromptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prompts")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    // CREATE
    @PostMapping
    public Prompt createPrompt(@RequestBody Prompt prompt) {
        return promptService.createPrompt(prompt);
    }

    // READ ALL
    @GetMapping
    public List<Prompt> getAllPrompts() {
        return promptService.getAllPrompts();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Prompt getPromptById(@PathVariable UUID id) {
        return promptService.getPromptById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Prompt updatePrompt(@PathVariable UUID id,
                               @RequestBody Prompt prompt) {
        return promptService.updatePrompt(id, prompt);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletePrompt(@PathVariable UUID id) {
        promptService.deletePrompt(id);
    }
}