import { TestBed } from '@angular/core/testing';

import { ChatBotChatService } from './chat-bot-chat.service';

describe('ChatBotChatService', () => {
  let service: ChatBotChatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChatBotChatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
