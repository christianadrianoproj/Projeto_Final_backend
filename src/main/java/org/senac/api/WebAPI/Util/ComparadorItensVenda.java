package org.senac.api.WebAPI.Util;

import java.util.Comparator;
import org.senac.api.WebAPI.domain.VendaItem;

/**
 *
 * @author Christian
 * Classe resposável pela ordenação (Comparação) dos Itens de uma venda.
 */

public class ComparadorItensVenda implements Comparator<VendaItem> {

    public int compare(VendaItem o1, VendaItem o2) {
        if (o1.getIdVendaItem() < o2.getIdVendaItem()) {
            return -1;
        } else if (o1.getIdVendaItem() > o2.getIdVendaItem()) {
            return +1;
        } else {
            return 0;
        }
    }
}
