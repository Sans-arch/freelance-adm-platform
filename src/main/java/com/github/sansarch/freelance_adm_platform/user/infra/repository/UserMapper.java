package com.github.sansarch.freelance_adm_platform.user.infra.repository;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.UserId;
import com.github.sansarch.freelance_adm_platform.user.infra.repository.builder.UserModelBuilder;
import com.github.sansarch.freelance_adm_platform.user.infra.repository.model.UserModel;

import java.util.Set;

public class UserMapper {

    public static User toDomainObject(UserModel model) {
        return User.builder()
                .id(UserId.from(model.getId()))
                .name(model.getName())
                .email(model.getEmail())
                .phone(model.getPhone())
                .password(model.getPassword())
                .document(new Document(model.getDocument(), DocumentType.valueOf(model.getDocumentType())))
                .accounts(Set.of(AccountType.CUSTOMER))
                .build();
    }

    public static UserModel toModel(User user) {
        return new UserModelBuilder()
                .id(user.getId().getValue())
                .name(user.getName())
                .email(user.getEmail().value())
                .phone(user.getPhone())
                .password(user.getPassword())
                .document(user.getDocument().value())
                .documentType(user.getDocument().type().name())
                .build();
    }
}
