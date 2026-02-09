import { useState } from "react";
import { api } from "../services/api";

export default function IARecommendation({ carro }) {
  const [peca, setPeca] = useState("");
  const [resposta, setResposta] = useState("");
  const [loading, setLoading] = useState(false);

  if (!carro) {
    return <p>Selecione um carro para gerar recomendações</p>;
  }

  async function gerarRecomendacao() {
    setLoading(true);
    setResposta("");

    try {
      const res = await api.post(`/gerar/${carro.id}`, {
        peca: peca
      });

      setResposta(res.data);
    } catch (e) {
      setResposta("Erro ao gerar recomendação");
    }

    setLoading(false);
  }

  return (
    <div className="ia-box">
      <h3>Carro selecionado:</h3>
      <p className="carro-selecionado">
        {carro.marca} {carro.modelo} {carro.versao} – {carro.motorizacao}
      </p>

      <input
        placeholder="Peça (ex: pneu, freio, suspensão)"
        value={peca}
        onChange={e => setPeca(e.target.value)}
      />

      <button onClick={gerarRecomendacao} disabled={loading || !peca}>
        {loading ? "Gerando..." : "Gerar recomendação"}
      </button>

      {resposta && (
        <div className="resposta-ia">
          <h4>Recomendação da IA</h4>
          <p>{resposta}</p>
        </div>
      )}
    </div>
  );
}
