package ru.otus.service;

import ru.otus.domain.User;

public class GetUserServiceImple implements GetUserService {
    final IOService ioService;
    final UserSequanceService userSequanceService;

    public GetUserServiceImple(IOService ioService, UserSequanceService userSequanceService) {
        this.ioService = ioService;
        this.userSequanceService = userSequanceService;
    }

    @Override
    public User getUser() {
        String firstName = ioService.userInput("Введите Ваше имя: ");
        String lastName  = ioService.userInput("Введите Вашу фамилию: ");
        return new User(userSequanceService.getID(),firstName,lastName);
    }
}
