/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadetest;

import dto.HistoryDTO;
import facades.DashboardFacade;
import interfaces.IDashboardFacade;
import javax.persistence.EntityManagerFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import utility.EntityManagerFactoryProvider;

/**
 *
 * @author sebastiannielsen
 */
public class DashboardFacadeTest {

    public DashboardFacadeTest() {
    }

    @Test
    public void testhistory() throws Exception  {
        EntityManagerFactory emf = EntityManagerFactoryProvider.getEntityManagerFactory();
        IDashboardFacade dashboardctrl = new DashboardFacade(emf);
        
        HistoryDTO history = dashboardctrl.getSearchHistory();
        
        assertTrue(history.getMostPopularDestinations().size() >= 0);
        assertTrue(history.getMostPopularMonths().size() >= 0);
        assertEquals(3, history.getNumberOfAirlines());
        assertTrue(history.getAverageNumberOfTickets() >= 0);
        assertTrue(history.getNumberOfReservations() == 3);
        assertTrue(history.getNumberOfSearches() >= 0);
    }
}
