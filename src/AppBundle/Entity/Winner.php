<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Winner
 *
 * @ORM\Table(name="winner")
 * @ORM\Entity
 */
class Winner
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_tab_winner", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idTabWinner;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="winner_date", type="date", nullable=false)
     */
    private $winnerDate;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_userwinner", type="integer", nullable=false)
     */
    private $idUserwinner;



    /**
     * Get idTabWinner
     *
     * @return integer
     */
    public function getIdTabWinner()
    {
        return $this->idTabWinner;
    }

    /**
     * Set winnerDate
     *
     * @param \DateTime $winnerDate
     *
     * @return Winner
     */
    public function setWinnerDate($winnerDate)
    {
        $this->winnerDate = $winnerDate;

        return $this;
    }

    /**
     * Get winnerDate
     *
     * @return \DateTime
     */
    public function getWinnerDate()
    {
        return $this->winnerDate;
    }

    /**
     * Set idUserwinner
     *
     * @param integer $idUserwinner
     *
     * @return Winner
     */
    public function setIdUserwinner($idUserwinner)
    {
        $this->idUserwinner = $idUserwinner;

        return $this;
    }

    /**
     * Get idUserwinner
     *
     * @return integer
     */
    public function getIdUserwinner()
    {
        return $this->idUserwinner;
    }
}
