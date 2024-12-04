package org.ticketbox.controller.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ticketbox.database.model.WaitingRoomSetting;
import org.ticketbox.service.setting.WaitingRoomSettingService;
import org.ticketbox.shared.base.BaseResponse;

@RestController
@RequestMapping("/waiting-room-settings")
public class WaitingRoomSettingController {
    @Autowired
    private WaitingRoomSettingService waitingRoomSettingService;

    @GetMapping("/{id}")
    public BaseResponse<WaitingRoomSetting> getWaitingRoomSettingById(@PathVariable Integer id) {
        return new BaseResponse<WaitingRoomSetting>(waitingRoomSettingService.getWaitingRoomById(id));
    }

    @PostMapping
    public BaseResponse<WaitingRoomSetting> createWaitingRoomSetting(@RequestBody WaitingRoomSetting waitingRoomSetting) {
        return new BaseResponse<>(waitingRoomSettingService.createWaitingRoomSetting(waitingRoomSetting));
    }

    @PutMapping("/{id}")
    public BaseResponse<WaitingRoomSetting> editWaitingRoomSetting(@PathVariable Integer id, @RequestBody WaitingRoomSetting waitingRoomSetting) {
        return new BaseResponse<>(waitingRoomSettingService.editWaitingRoomSetting(id, waitingRoomSetting));
    }
}
