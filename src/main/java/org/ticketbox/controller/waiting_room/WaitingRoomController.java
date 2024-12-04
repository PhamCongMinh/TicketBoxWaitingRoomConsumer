package org.ticketbox.controller.waiting_room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketbox.service.wating_room.WaitingRoomService;
import org.ticketbox.shared.base.BaseResponse;
import org.ticketbox.shared.dto.waiting_room.JoinWaitingRoomDto;

@RestController
@RequestMapping("waiting_rooms")
public class WaitingRoomController {
    @Autowired
    private WaitingRoomService waitingRoomService;

    @PostMapping
    public BaseResponse<String> checkAndGetQueueNum(@RequestBody JoinWaitingRoomDto joinWaitingRoomDto) {
        return new BaseResponse<>(waitingRoomService.checkAndGetQueueNum(joinWaitingRoomDto));
    }
}
