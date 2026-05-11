package fr.univ_amu.iut.exercice4;

/// Kata 4 - Pagination.
///
/// Kata algorithmique avec beaucoup de cas limites. Idéal pour pratiquer la
/// **discipline TDD** : on active les tests dans l'ordre (du plus simple au plus
/// complexe) et on résiste à la tentation d'anticiper.
public class Pagination {

  private final int courant;
  private final int total;

  public Pagination(int courant, int total) {
    this.courant = courant;
    this.total = total;
  }

  /// Retourne la représentation textuelle de la barre de pagination.
  ///
  /// Format : pages séparées par des espaces, page courante entre parenthèses,
  /// `...` pour combler les trous quand il y a plus de 7 pages au total.
  public String afficher() {
    StringBuilder sortie = new StringBuilder();
    // TODO kata 4 : construire la chaîne de pagination selon les règles
    // du README. Activez les tests dans l'ordre, ils vous guident :
    // - d'abord le cas "total <= 7" (affichage complet)
    // - puis le cas "beaucoup de pages" avec gestion des ellipses
    if (total <= 7) {
      // Cas simple : on affiche toutes les pages
      for (int i = 1; i <= total; i++) {
        if (i > 1) {
          sortie.append(" ");
        }
        if (i == courant) {
          sortie.append("(").append(i).append(")");
        } else {
          sortie.append(i);
        }
      }
    } else {
      // Cas avec ellipses : on collecte les pages à afficher
      // Pages clés : 1, courant-1, courant, courant+1, total
      java.util.TreeSet<Integer> pages = new java.util.TreeSet<>();
      pages.add(1);
      if (courant - 1 >= 1) pages.add(courant - 1);
      pages.add(courant);
      if (courant + 1 <= total) pages.add(courant + 1);
      pages.add(total);

      int precedent = 0;
      for (int page : pages) {
        if (precedent > 0) {
          if (page - precedent > 1) {
            sortie.append(" ...");
          }
          sortie.append(" ");
        }
        if (page == courant) {
          sortie.append("(").append(page).append(")");
        } else {
          sortie.append(page);
        }
        precedent = page;
      }
    }

    return sortie.toString();
  }
}
