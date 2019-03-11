package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.domain.User;
import ru.otus.io.IOService;

@Service
public class GetUserServiceImpl implements GetUserService {
    final IOService ioService;
    final SequenceService  userSequenceService;

    @Autowired
    public GetUserServiceImpl(IOService ioService, @Qualifier("userSequenceService") SequenceService  userSequanceService) {
        this.ioService = ioService;
        this.userSequenceService = userSequanceService;
    }

    @Override
    public User getUser() {
        String firstName = ioService.userInput(ioService.printLocaleMes("test.enterFName")+": ");
        String lastName  = ioService.userInput(ioService.printLocaleMes("test.enterLName")+": ");
        return new User(userSequenceService.getID(),firstName,lastName);
    }
}
