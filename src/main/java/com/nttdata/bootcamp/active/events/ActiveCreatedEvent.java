package com.nttdata.bootcamp.active.events;

import com.nttdata.bootcamp.active.model.Active;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Event active.
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActiveCreatedEvent extends Event<Active> {

}
