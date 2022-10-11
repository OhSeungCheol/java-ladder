package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Gamer> gamers;
    private final Ladder ladder;

    public Ladder getLadder() {
        return ladder;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public Game(List<Gamer> gamers, Height ladderHeight, BridgeInterface bridgeInterface) {
        this.gamers = gamers;
        this.ladder = new Ladder(gamers.size(), ladderHeight, bridgeInterface);
    }

    public int getResultIndex(int startIndex) {
        Line startLine = ladder.getStartLine();
        LadderPiece startLadderPiece = startLine.getLadderPiece(startIndex);
        return startLadderPiece.moveToLadder(startIndex);
    }

    public List<Integer> getResultAll() {
        List<Integer> resultIndexes = new ArrayList<>();
        Line startLine = ladder.getStartLine();
        for (Gamer gamer : gamers) {
            int index = gamer.getIndex();
            LadderPiece startLadderPiece = startLine.getLadderPiece(index);
            resultIndexes.add(startLadderPiece.moveToLadder(index));
        }
        return resultIndexes;
    }
}