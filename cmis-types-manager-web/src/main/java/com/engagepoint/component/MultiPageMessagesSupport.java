package com.engagepoint.component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: sergii.serba
 * Date: 12/4/13
 * Time: 2:48 PM
 */
public class MultiPageMessagesSupport implements PhaseListener {
    private static final String SESSION_TOKEN = "MULTI_PAGE_MESSAGES_SUPPORT";

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    @Override
    public void beforePhase(final PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();

        if (PhaseId.RENDER_RESPONSE.equals(event.getPhaseId()) &&
                (!facesContext.getResponseComplete())) {
            restoreMessages(facesContext);
        }
    }

    @Override
    public void afterPhase(final PhaseEvent event) {
        if (event.getPhaseId() == PhaseId.APPLY_REQUEST_VALUES ||
                event.getPhaseId() == PhaseId.PROCESS_VALIDATIONS ||
                event.getPhaseId() == PhaseId.INVOKE_APPLICATION) {
            FacesContext facesContext = event.getFacesContext();
            this.saveMessages(facesContext);
        }
    }

    @SuppressWarnings("unchecked")
    private int saveMessages(final FacesContext facesContext) {
        List<FacesMessage> messages = new ArrayList<FacesMessage>();
        for (Iterator<FacesMessage> iter = facesContext.getMessages(null); iter.hasNext(); ) {
            messages.add(iter.next());
            iter.remove();
        }

        if (messages.isEmpty()) {
            return 0;
        }

        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
        List<FacesMessage> existingMessages = (List<FacesMessage>) sessionMap.get(SESSION_TOKEN);
        if (existingMessages != null) {
            existingMessages.addAll(messages);
        } else {
            sessionMap.put(SESSION_TOKEN, messages);
        }
        return messages.size();
    }

    @SuppressWarnings("unchecked")
    private int restoreMessages(final FacesContext facesContext) {
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
        List<FacesMessage> messages = (List<FacesMessage>) sessionMap.remove(SESSION_TOKEN);

        if (messages == null) {
            return 0;
        }

        int restoredCount = messages.size();
        for (Object element : messages) {
            facesContext.addMessage(null, (FacesMessage) element);
        }
        return restoredCount;
    }

}