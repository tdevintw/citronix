package dev.yassiraitelghari.citronix.service;

import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.dto.Tree.TreeCreateDTO;

import java.util.UUID;

public interface TreeService {

    Tree create(UUID id , TreeCreateDTO createDTO);
}
