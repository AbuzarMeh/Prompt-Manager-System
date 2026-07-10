package com.ats.prompt_service.service.impl;

import com.ats.prompt_service.entity.Prompt;
import com.ats.prompt_service.repository.PromptRepository;
import com.ats.prompt_service.service.PromptService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    // Constructor Injection
    public PromptServiceImpl(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    @Override
    public Prompt createPrompt(Prompt prompt) {
        return promptRepository.save(prompt);
    }

    @Override
    public List<Prompt> getAllPrompts() {
        return promptRepository.findAll();
    }

    @Override
    public Prompt getPromptById(UUID id) {
        return promptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prompt not found with id: " + id));
    }

    @Override
    public Prompt updatePrompt(UUID id, Prompt updatedPrompt) {

        Prompt existingPrompt = getPromptById(id);

        existingPrompt.setName(updatedPrompt.getName());
        existingPrompt.setDescription(updatedPrompt.getDescription());
        existingPrompt.setContent(updatedPrompt.getContent());
        existingPrompt.setTags(updatedPrompt.getTags());
        existingPrompt.setModelTarget(updatedPrompt.getModelTarget());

        return promptRepository.save(existingPrompt);
    }

    @Override
    public void deletePrompt(UUID id) {

        Prompt existingPrompt = getPromptById(id);

        promptRepository.delete(existingPrompt);
    }
}