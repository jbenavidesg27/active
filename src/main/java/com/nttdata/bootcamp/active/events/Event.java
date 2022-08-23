package com.nttdata.bootcamp.active.events;

import java.util.Date;
import lombok.Data;

/**
 * Class Event for Data.
 *
 */
@Data
public abstract class Event<T> {
  private String id;
  private Date date;
  private EventType type;
  private T data;
}
