package it.polito.tdp.gosales.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.gosales.dao.GOsalesDAO;

public class Model {
	private GOsalesDAO dao;
	private SimpleWeightedGraph<Retailers, DefaultWeightedEdge> grafo;
	private Map <Integer, Retailers> idMap;
	
	
	public Model() {
		this.dao = new GOsalesDAO();
		this.idMap = this.dao.getIdMap();
	}
	public void creaGrafo(String country, int anno) {
		//inizializzo il grafo
		this.grafo = new SimpleWeightedGraph<Retailers, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		//aggiungo i vertici
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(country));
		
		//aggiungo gli archi
		List<Arco> archi = this.dao.getArco(anno, country, idMap);
		//System.out.println(archi.size());
		for (Arco a : archi){
			Graphs.addEdgeWithVertices(this.grafo, a.getR1(), a.getR2(), a.getPeso());
		}
	}
	/**
	 * Si definisca come “volume di vendita” di un retailer
	 * la somma dei pesi di tutti gli archi ad esso incidenti
	 */
	public List<Retailers> volumiVendita() {
		for (Retailers r : this.grafo.vertexSet()) {
			int volume = 0;
			Set<DefaultWeightedEdge> archiEntranti = this.grafo.incomingEdgesOf(r);
			for (DefaultWeightedEdge e : archiEntranti) {
				volume += this.grafo.getEdgeWeight(e);
			}
			r.setVolume(volume);
		}
		List<Retailers> volumiV = new ArrayList<>(this.grafo.vertexSet());
		Collections.sort(volumiV);
		return volumiV;
	}
	
	public List<String> getNazioni(){
		return this.dao.getNazioni();
	}

	public List<Integer> getAnno() {
		return this.dao.getAnno();
	}
	public int numV() {
		return this.grafo.vertexSet().size();
	}
	public int numA() {
		return this.grafo.edgeSet().size();
	}
	
}
